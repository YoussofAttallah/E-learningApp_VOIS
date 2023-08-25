
import React, { useState } from 'react';
import axios from 'axios';
import CourseCard from './CourseCard';
import './styles.css';
import {Link } from 'react-router-dom';
function CourseFinder() {
  const [courseTitle, setcourseTitle] = useState('');
  const [courses, setcourses] = useState(null);
  const [error, setError] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(courseTitle)
    try {
      const response = await axios.get(`http://localhost:8080/api/courses/findByTitle/${courseTitle}`);
      console.log('Courses data:', response.data);
      setcourses(response.data);
      console.log(response.data);

      setError(null);
    } catch (err) {
      setError('Course not found');
      setcourses(null);
      console.log(err)
    }
  };

  return (
    <div className="CourseFinder">
      <Link to="/add">Add Course</Link>
      <h1>find Course By Title</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Course ID:
          <input type="text" value={courseTitle} onChange={(e) => setcourseTitle(e.target.value)} />
        </label>
        <button type="submit">Find Course</button>
      </form>
      {courses && (
        <div>
          {courses.map(course => (
            <CourseCard key={course.id} course={course} />
          ))}
        </div>
      )}
      {error && <p>{error}</p>}
    </div>
  );
}

export default CourseFinder;
