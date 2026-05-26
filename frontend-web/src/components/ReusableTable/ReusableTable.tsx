import {useEffect, useRef } from "react";
import $ from "jquery";
import "datatables.net-dt";
import "datatables.net-dt/css/dataTables.dataTables.css";
import "./ReusableTable.css";

const DataTable = ({
    columns,
    data,
    options = {},
    className = "",    
}) => {
    const tableRef = useRef();

    useEffect(() => {
        const table = $(tableRef.current).DataTable({
            data,
            columns,
            destroy: true,
            responsive: true,
            language: {
                url: "https://cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json",
            },
            ...options,
        });

        return () => {
            table.destroy();
        };
    }, [data]);

    return (
        <table
            ref={tableRef}
            className={`display ${className}`}
            style={{ width: "100%" }}
        />
    );
};

export default DataTable;