import React from 'react';


import classes from './InstructorCard.module.css'
import img2 from '../../assets/imgs/images.png'
import img3 from '../../assets/imgs/rating.png'
import { NavLink, useNavigate } from "react-router-dom";
function CourseCard({ instructor }) {
    const navigate = useNavigate();
    console.log("data in instructorCard", instructor)

    if (!instructor) {
        return <div>Loading...</div>; // Or any other fallback behavior
    }
  //TO be DONE 
    const handleclick=(id)=>{
        navigate(`/course/${id}`)
    }
    return (
        
        <div className={classes.course_card} onClick={() => handleclick(instructor.instructorId)}>

                <div className={classes.course_details}>
                <p className={classes.headerc}>{instructor.instructorName}</p>
                    
                    <div className={classes.instructor}>
                        <p>Instructor Id: {instructor.instructorId}</p>
                    </div>
                <a href={instructor.link} target="_blank" rel="noopener noreferrer">instructor Link</a>

                    
                    <div className={classes.elementcontainer}>
                        <div className={classes.imgcontainer}>
                            <img src={img3} className={classes.imgt} />
                        </div>
                    <p>Rating: {instructor.ratingTotal}</p>

                    </div>



                    
                </div>
            </div>

                    
           
          
    );
}

export default CourseCard;
