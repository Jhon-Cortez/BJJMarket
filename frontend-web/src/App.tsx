import './App.css';
import SearchBar from './components/SearchBar/SearchBar';
import MainLayout from './layouts/MainLayout'

function App(){
  return (
    <MainLayout>
        <h1>Welcome to BJJ Market</h1>
        <SearchBar />
    </MainLayout>
  )
}
export default App;