import "./CategoryItem.css";
type CategoryItemProps = {
    name: string;
};
function CategoryItem({ name }: CategoryItemProps) {
    return (
        <li className="category-item">
            {name}
        </li>
    );
}
export default CategoryItem;