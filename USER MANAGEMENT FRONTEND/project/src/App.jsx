import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Home from "./pages/Home";
import axios from "axios";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import AddUser from "./users/AddUser";
import EditUser from "./users/EditUser";
import ViewUser from "./users/ViewUser";
import Color from "./pages/color";


function App() {

  return (
    <>
    <Router>
      <Routes>
      <Route exact path="/" element={<Home></Home>}></Route>
      <Route exact path="/adduser" element={<AddUser></AddUser>}></Route>
      <Route exact path="/edituser/:userId" element={<EditUser></EditUser>}></Route>
      <Route exact path="/viewuser/:userId" element={<ViewUser></ViewUser>}></Route>
      
      </Routes>
    </Router>
    </>
  )
}

export default App
