import React from 'react';
import { Divider, Flex, Tag } from 'antd';
import returnRandomVerse from './../logic/verses.js'

const k = process.env.API_BIBLE_CREDS_KEY;
const url = process.env.API_BIBLE_CREDS_URL;

const params = new URLSearchParams();
params.append("q", returnRandomVerse());

export default async function bibleVerseDisplay() {
    const data = await fetch(`${url}?${params.toString()}` , 
        { 
            method: "GET", 
            headers: 
            {
                "Authorization" : k
            }
        }
    )
    const posts = await data.json()
    var initRes = JSON.stringify(posts.passages)
    var parseIndex = initRes.match(/([A-Za-z0-9]+(?: [A-Za-z0-9]+)* \d+:\d+(?:–\d+)?)/);
    var parseVerse = initRes.match(/\[\d+\]\s*(.*?)(?=\s*(?:\[\d+\]|\(ESV\)))/g);
    var index = parseIndex[1];

    if (parseVerse) {
        // Clean each verse by removing the markers from each match
        var verseContent = parseVerse.map(v => v.replace(/\[\d+\]\s*/, '').trim());
    }

    return (
        <div>
            <Divider variant="dotted" style={{ borderColor: 'yellow' }}></Divider>
            <Flex gap="middle">
                <h3>{index}</h3>
                <Tag color="yellow"> English Standard Version </Tag>
            </Flex>
            <p>{verseContent}</p>
            <Divider variant="dotted" style={{ borderColor: 'yellow' }}></Divider>
        </div>
    )
}