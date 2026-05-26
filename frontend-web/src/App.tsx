import './App.css';
import SearchBar from './components/SearchBar/SearchBar';
import MainLayout from './layouts/MainLayout'

function App(){
  return (
    <MainLayout>
        <SearchBar />
    </MainLayout>
  )
}
export default App;