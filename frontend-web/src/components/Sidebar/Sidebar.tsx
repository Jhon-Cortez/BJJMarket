import { useAuth } from "../../context/AuthContext";
import CategoryItem from "../CategorItem/CategoryItem";
import "./Sidebar.css";

function Sidebar() {
    const categories = ["Bebidas", "Snacks", "Lacteos", "Carnes", "Higiene", "Limpeza"];
    const { user, logout } = useAuth();

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
            {user && (
                <div className="sidebar-user">
                    <span>{user.username}</span>
                    <button onClick={logout}>Cerrar sesión</button>
                </div>
            )}
        </aside>
    );
}
export default Sidebar;