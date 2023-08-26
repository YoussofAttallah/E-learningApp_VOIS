import React from 'react';


import classes from './card.module.css'
import img2 from '../../assets/imgs/images.png'
import img3 from '../../assets/imgs/rating.png'
import { NavLink, useNavigate } from "react-router-dom";
function CourseCard({ course }) {
    const navigate = useNavigate();
    console.log("data in courseCard", course)
    console.log("data for instructor", course["instructor"])
    if (!course || !course.instructor) {
        return <div>Loading...</div>; // Or any other fallback behavior
    }
  
    const handleclick=(id)=>{
        navigate(`/course/${id}`)
    }
    return (
        
        <div className={classes.course_card} onClick={() => handleclick(course.id)}>
                <div className={classes.courseimgcontainer}>
                    <img className={classes.course_image} src={course.imageLink} alt={course.title} />

                </div>

                <div className={classes.course_details}>
                    <p className={classes.headerc}>{course.title}</p>
                    <div className={classes.elementcontainer}>
                        <div className={classes.imgcontainer}>
                            <img src={img2} className={classes.imgt} />
                        </div>
                        <p className={classes.dur}>{course.duration} hours</p>

                    </div>
                    <div className={classes.elementcontainer}>
                        <div className={classes.imgcontainer}>
                            <img src={img3} className={classes.imgt} />
                        </div>
                        <p>Rating: {course.totalRating}</p>

                    </div>



                    <div className={classes.instructor}>
                        <p>Instructor: {course.instructor.instructorName}</p>

                    </div>
                </div>
            </div>

                    
           
          
    );
}

export default CourseCard;
