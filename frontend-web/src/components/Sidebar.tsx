import CategoryItem from "./CategoryItem";

function Sidebar() {
    const categories = ["Bebidas", "Snacks", "Lacteos", "Carnes", "Higiene", "Limpeza"];
    return (
        <aside>
            <h2>Categorias</h2>
            <ul>
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