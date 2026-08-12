import { useEffect, useRef } from "react";
import $ from "jquery";
import "datatables.net-dt";
import "datatables.net-dt/css/dataTables.dataTables.css";
import "./ReusableTable.css";

type Column = {
    title: string;
    data: string;
};

type DataTableProps = {
    title?: string;
    columns: Column[];
    data: unknown[];
    options?: Record<string, unknown>;
    className?: string;
};

const DataTable = ({ title, columns, data, options = {}, className = "" }: DataTableProps) => {
    const tableRef = useRef<HTMLTableElement>(null);
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    const dtInstanceRef = useRef<any>(null);

    useEffect(() => {
        dtInstanceRef.current = $(tableRef.current!).DataTable({
            columns,
            data: [],
            destroy: true,
            language: {
                url: "https://cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json",
            },
            ...options,
        });

        return () => {
            dtInstanceRef.current?.destroy();
            dtInstanceRef.current = null;
        };
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    useEffect(() => {
        const table = dtInstanceRef.current;
        if (!table) return;
        table.clear();
        table.rows.add(data);
        table.draw();
    }, [data]);

    return (
        <div className={className}>
            {title && <h2>{title}</h2>}
            <table ref={tableRef} className="display" style={{ width: "100%" }} />
        </div>
    );
};

export default DataTable;
