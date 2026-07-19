import React from 'react';

// a. Display Odd Team Players and Even Team players using ES6 destructuring
export function OddPlayers([first, , third, , fifth]) {
  return (
    <div>
      <li> First : {first} </li>
      <li> Third : {third} </li>
      <li> Fifth : {fifth}</li>
    </div>
  );
}

export function EvenPlayers([, second, , fourth, , sixth]) {
  return (
    <div>
      <li> Second : {second} </li>
      <li> Fourth : {fourth} </li>
      <li> Sixth : {sixth}</li>
    </div>
  );
}

// b. Merge T20players and RanjiTrophy players using the ES6 spread/merge feature
const T20players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
export const IndianPlayers = [...T20players, ...RanjiTrophyPlayers];

export function ListofIndianPlayers({ IndianPlayers }) {
  return (
    IndianPlayers.map((item) => {
      return (
        <li key={item}>Mr. {item}</li>
      );
    })
  );
}
