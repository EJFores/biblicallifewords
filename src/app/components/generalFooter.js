import styles from "./../page.module.css";
import ESVCR from "./esvCopyright.js";
import CVLink from "./cvLink.js"

const foof = () => {

    return (
        <footer className={styles.footer}>
        <CVLink></CVLink>
        <ESVCR></ESVCR>
      </footer>
    );
};

export default foof;