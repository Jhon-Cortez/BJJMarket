export interface Product {
    product_id: number;
    name: string;
    description: string;
    sku: string;
    status: boolean;

    product_price: {
        product_price_id: number;
        product_id: number;
        price: number;
    };
}