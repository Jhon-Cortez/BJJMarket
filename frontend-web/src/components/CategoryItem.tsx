type CategoryItemProps = {
    name: string;
};
function CategoryItem({ name }: CategoryItemProps) {
    return (
        <li>
            {name}
        </li>
    );
}
export default CategoryItem;