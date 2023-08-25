import React from 'react';
import { BrowserRouter, Router,Routes, Route, Link } from 'react-router-dom';
import CourseFinder from './CourseFinder';
import AddCourseForm from './AddCourseForm';
import CourseList from './CourseList';
import CoursePage from './CoursePage';
import './App.css';

function App() {
  return (
    <div className="app">
      
      
      <BrowserRouter>
      <Routes>
        
        <Route path="/" element={<CourseFinder/>} />
        <Route path="/all" element={<CourseList />} />
        <Route path="/course/:id" element={<CoursePage/>} />
        <Route path="/add" element={<AddCourseForm/>} />
        
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
