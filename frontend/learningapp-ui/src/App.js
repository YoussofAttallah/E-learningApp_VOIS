import React from 'react';
import { BrowserRouter, Router,Routes, Route, Link } from 'react-router-dom';
import CourseFinder from './Pages/search/CourseFinder';
import AddCourseForm from './Pages/addcourse/AddCourseForm';
import CoursePage from './CoursePage';
import NavBar from './Components/navbar/NavBar';
import './App.css';
import Homepage from './Pages/homepage/Homepage';
import AddInstructorForm from './Pages/addInstructor/AddInstructorForm';
import Instructors from './Pages/instructors/Instructors';
import Instructorpage from './Pages/instructorPage/Instructorpage';
function App() {
  return (
    <div className="app">
      <NavBar/>
      
    
      <Routes>
        
        <Route path="/" element={<CourseFinder/>} />
        <Route path="/all" element={<Homepage />} />
        <Route path="/course/:id" element={<CoursePage/>} />
        <Route path="/add" element={<AddCourseForm/>} />
        <Route path="/instructor/add" element={<AddInstructorForm />} />
        <Route path="/instructor/all" element={<Instructors />} />
        <Route path="/instructor/:id" element={<Instructorpage />} />

        
      </Routes>
    
    </div>
  );
}

export default App;
