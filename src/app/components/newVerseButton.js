'use client'

import React, { useState } from 'react';
import { useRouter } from 'next/navigation'
import { Button } from 'antd';

const NvButton = () => {
  const router = useRouter()
  const [key, setKey] = useState(0);  // This will be used to trigger a re-render

  const handleClick = () => {
    router.refresh();  // Refresh the route (data fetching if needed)
    setKey(prevKey => prevKey + 1);  // Update the key to trigger a re-render
  }

  return (
    <>
      <Button color="cyan" variant="solid" size="middle" onClick={handleClick}>
        Click here to generate another Bible verse
      </Button>
    </>
  );
};

export default NvButton;