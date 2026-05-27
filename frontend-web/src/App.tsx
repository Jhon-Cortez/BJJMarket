import './App.css'

import { ProductCard } from './components/ProductCard';

function App() {

  const products = [
    {
      product_id: 1,
      name: "Leche",
      description: "Leche deslactosada",
      sku: "LCH-01",
      status: true,

      product_price: {
        product_price_id: 1,
        product_id: 1,
        price: 4500,
      },
    },

    {
      product_id: 2,
      name: "Arroz",
      description: "Arroz premium",
      sku: "ARR-02",
      status: true,

      product_price: {
        product_price_id: 2,
        product_id: 2,
        price: 3200,
      },
    },
  ];

  return (
    <div className="container">

      {
        products.map(product => (
          <ProductCard
            key={product.product_id}
            product={product}
          />
        ))
      }

    </div>
  );
}

export default App;