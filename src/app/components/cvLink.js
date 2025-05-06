import React from 'react';
import { Button } from 'antd';
import Image from "next/image";
import styles from "./../page.module.css";

const cv = () => {

    return (
        <Button className={styles.footButtons} type="link">
          <a
            href="http://ethanflores.me"
            target="_blank"
            rel="noopener noreferrer"
          >
            <Image
              aria-hidden
              src="/cv.svg"
              alt="CV Icon"
              width={16}
              height={16}
            />
            Made by EJF
          </a>
        </Button>
    );
};

export default cv;