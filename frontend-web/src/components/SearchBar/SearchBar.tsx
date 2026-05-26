import "./SearchBar.css"

function SearchBar() {
    return(
        <div className="search-bar-container">
            <input className="search-bar-input" type="text" placeholder="Search..." />
        </div>
    )
}
export default SearchBar;