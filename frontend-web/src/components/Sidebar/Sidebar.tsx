import CategoryItem from "../CategorItem/CategoryItem";
import "./Sidebar.css";

function Sidebar() {
    const categories = ["Bebidas", "Snacks", "Lacteos", "Carnes", "Higiene", "Limpeza"];
    return (
        <aside className="sidebar">
            <h2 className="title-sidebar">Categorias</h2>
            <ul className="categories-list">
                {categories.map((category) => (
                    <CategoryItem 
                        key={category} 
                        name={category} 
                    />
                ))}
            </ul>
        </aside>
    );
}
export default Sidebar;