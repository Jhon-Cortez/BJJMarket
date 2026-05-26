import './App.css';
import MainLayout from './layouts/MainLayout'
import Productos from './view/products/Products';

function App(){
  return (
    <MainLayout>
        <h1>Dashboard</h1>

        <Productos />
    </MainLayout>
  )
}
export default App;