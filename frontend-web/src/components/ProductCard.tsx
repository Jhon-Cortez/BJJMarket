import { Product } from "../models/Product";

interface Props {
    product: Product;
}

export const ProductCard = ({ product }: Props) => {

    const addToCart = () => {
        alert(`${product.name} agregado al carrito`);
    };

    return (
        <div className="card">

            <h2>{product.name}</h2>

            <p>{product.description}</p>

            <span className="price">
                ${product.product_price.price}
            </span>

            <button onClick={addToCart}>
                Añadir al carrito
            </button>

        </div>
    );
};