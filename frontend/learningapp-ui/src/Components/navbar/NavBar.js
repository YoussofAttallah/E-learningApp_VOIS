import classes from "./navBar.module.css"
import img1 from "../../assets/imgs/download.png"
import { NavLink } from "react-router-dom";
const NavBar = (props) => {
    

    return (
        <div className={classes.Navbarcontainer}>
            <div className={classes.logocontainer}>
                <div className={classes.imgcontainer}>
                    <img src={img1} className={classes.imgc} />
                </div>
                <p className={classes.header}>_VOIS <span className={classes.lh}>Learning Hub</span></p>
            </div>
            <div className={classes.navbar2conrainer}>
                <NavLink to="/all" activeClassName={classes.activeLink}>
                    <div className={classes.navbarelement}>Home</div>    
                </NavLink>
                <NavLink to="/add" activeClassName={classes.activeLink}>
                    <div className={classes.navbarelement}>Add course</div>
                </NavLink>
                <NavLink to="/" activeClassName={classes.activeLink}>
                    <div className={classes.navbarelement}>Search</div>
                </NavLink>
            </div>

       
                     
        
        </div>
    );
};

export default NavBar;
