import "./SearchBar.css"

function SearchBar() {
    return(
        <div className="search-bar">
            <input type = "text" placeholder="Search products" className="search-input"/>
        </div>
    )
}
export default SearchBar;