const verses = [
    'Ephesians 1 7-8',
    'Psalm 139 14',
    'Philippians 4 13',
    'Romans 8 37',
    'John 1 9',
    'Matthew 5 13-14',
    'Romans 8 16-17',
    'Jeremiah 31 3',
    '1 Corinthians 6 19-20',
    'Genesis 12 2',
    'Joshua 1 9',
    '2 Corinthians 5 17',
    'John 15 16',
    'Ephesians 1 7',
    'Deuteronomy 28 13',
    '1 John 4 7',
    '1 Peter 2 9',
    'Ephesians 6 10',
    'Revelation 12 11',
    'John 16 13',
    'Psalm 119 90',
    'Jeremiah 17 7',
    'Matthew 5 16',
    'Romans 8 1',
    'Deuteronomy 31 6',
    'Ecclesiastes 3 11',
    'Romans 6 13'
]

function getRndInteger(min, max) {
    return Math.floor(Math.random() * (max - min) ) + min;
  }

export default function returnRandomVerse()
{
    return verses[getRndInteger(1,verses.length)]
}