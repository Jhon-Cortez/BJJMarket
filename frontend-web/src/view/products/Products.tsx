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
            const response = await api.get("/v1/products");

            setProductos(response.data);
        } catch (error) {
            console.error(error);
        }
    };

    const columns = [
        {
            title: "Nombre",
            data: "name",
        },
        {
            title: "Sku",
            data: "sku",
        },
        {
            title: "Descripción",
            data: "description",
        },
        {
            title: "Categoría",
            data: "category_id",
        },
        {
            title: "Estado",
            data: "status",
        }
    ];

    return <DataTable title="Productos" columns={columns} data={productos} />;
};

export default Productos;
