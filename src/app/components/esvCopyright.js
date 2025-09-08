'use client'

import React, { useState } from 'react';
import { Radio, Space, Modal } from 'antd';
import styles from "./../page.module.css";


const App = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const showModal = () => {
    setIsModalOpen(true);
  };
  const handleOk = () => {
    setIsModalOpen(false);
  };
  const handleCancel = () => {
    setIsModalOpen(false);
  };
  return (
    <>
      <Space>
        <Radio.Group>
          <Radio.Button value="ESV Copyright" onClick={showModal} className={styles.footButtons}>ESV Copyright</Radio.Button>
          <Radio.Button value="esv.org" className={styles.footButtons} >
          <a
              href="https://esv.org"
              target="_blank"
              rel="noopener noreferrer"
            >
              esv.org
          </a>
          </Radio.Button>
        </Radio.Group>
      </Space>
      <Modal title="Basic Modal" open={isModalOpen} onOk={handleOk} onCancel={handleCancel}>
        <p>
          Scripture quotations are from the ESV® Bible (The Holy Bible, English Standard Version®), © 2001 by Crossway, a publishing ministry of Good News Publishers. Used by permission. All rights reserved. The ESV text may not be quoted in any publication made available to the public by a Creative Commons license. The ESV may not be translated into any other language.
          Users may not copy or download more than 500 verses of the ESV Bible or more than one half of any book of the ESV Bible.
          Scripture quotations marked “ESV” are from the ESV® Bible (The Holy Bible, English Standard Version®), © 2001 by Crossway, a publishing ministry of Good News Publishers. Used by permission. All rights reserved. The ESV text may not be quoted in any publication made available to the public by a Creative Commons license. The ESV may not be translated into any other language.
          Unless otherwise indicated, all Scripture quotations are from the ESV® Bible (The Holy Bible, English Standard Version®), © 2001 by Crossway, a publishing ministry of Good News Publishers. Used by permission. All rights reserved. The ESV text may not be quoted in any publication made available to the public by a Creative Commons license. The ESV may not be translated into any other language.
        </p>
      </Modal>
    </>
  );
};
export default App;