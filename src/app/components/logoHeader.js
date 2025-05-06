import styles from "./../page.module.css";
import Image from "next/image";

const logoHeader = () => {
    return (
      <div>
        <div className={styles.logo}>
        <Image
          src="bible.svg"
          alt="Bible.logo"
          width={50}
          height={50}
          priority
        /> <h1> Biblical Life Words</h1>
        </div>
        <br></br>
        <div className={styles.notes}>
          <p>Generator that returns randomly selected life giving words from the Bible.</p>
        </div>
      </div>
    );
};

export default logoHeader;
