import styles from "./page.module.css";
import Header from "./components/logoHeader.js"
import ComFooter from "./components/generalFooter.js"
import BibleVerseDisplay from "./components/bibleVerseDisplay.js";
import NewVerseButton from "./components/newVerseButton.js"

export default function Home() {
  return (
    <div className={styles.page}>
      <main className={styles.main}>
        <Header></Header>
        <BibleVerseDisplay></BibleVerseDisplay>
        <NewVerseButton></NewVerseButton>
      </main>
      <ComFooter></ComFooter>
    </div>
  );
}