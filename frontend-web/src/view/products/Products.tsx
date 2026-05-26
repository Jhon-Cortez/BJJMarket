import { useEffect, useState } from "react";
import api from "../../services/api";
import DataTable from "../../components/ReusableTable/ReusableTable";

const Productos = () => {
    const [productos, setProductos] = useState([]);

    useEffect(() => {
        acquireProducts();
    }, []);

    const acquireProducts = async () => {
        try {
            const response = await api.get("/productos");

            setProductos(response.data);
        } catch (error) {
            console.error(error);
        }
    };

    const columns = [
        {
            title: "ID",
            data: "product_id",
        },
        {
            title: "Categoria",
            data: "category_id",
        },
        {
            title: "Sku",
            data: "sku",
        },
        {
            title: "Description",
            data: "description",
        },
        {
            title: "Status",
            data: "status",
        }
    ];

    return <DataTable title="Productos" columns={columns} data={productos} />;
};

export default Productos;
