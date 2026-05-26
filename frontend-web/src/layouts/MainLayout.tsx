import Sidebar from "../components/Sidebar/Sidebar";
import "./MainLayaout.css";
type MainLayoutProps = {
    children: React.ReactNode;
};
const MainLayout = ({ children }: MainLayoutProps) => {
    return (
        <div className="layout">
            <Sidebar />
            <main className="content">
                {children}
            </main>
        </div>
    );
};
export default MainLayout;