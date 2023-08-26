import React, { useState } from "react";
import axios from "axios";
import Card from "../../Components/Card/Card";
import classes from "./courseFinder.module.css";
// **Created a new css file and imported it**
import "./courseFinder.css";

function CourseFinder() {
  const [courseTitle, setcourseTitle] = useState("");
  const [courses, setcourses] = useState(null);
  const [error, setError] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(courseTitle);
    try {
      const response = await axios.get(
        `http://localhost:8080/api/courses/findByTitle/${courseTitle}`
      );
      console.log("Courses data:", response.data);
      setcourses(response.data);
      console.log(response.data);

      setError(null);
    } catch (err) {
      setError("Course not found");
      setcourses(null);
      console.log(err);
    }
  };

  return (
    <div className={classes.allh}>
      <h1>Find Course By Title</h1>
      <form onSubmit={handleSubmit}>
        <label>
          {/* **Removed "Course Title" Text and added placeholder to input** */}
          <input
            type="text"
            value={courseTitle}
            placeholder="Search"
            onChange={(e) => setcourseTitle(e.target.value)}
          />
        </label>
        <button type="submit">Find Course</button>
      </form>
      {courses && (
        <div className={classes.cardcontainer}>
          {courses.map((course) => (
            <Card key={course.id} course={course} />
          ))}
        </div>
      )}
      {error && <p>{error}</p>}
    </div>
  );
}

export default CourseFinder;
