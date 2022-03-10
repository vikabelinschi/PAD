const express = require('express');
const router = express.Router();
const con = require('mysql2');


const db = require('./db');
const config = require('./config');

async function getMultiple(video_id){
  const rows = await db.query(
    `SELECT * FROM likes WHERE video_id = ` + video_id
  );
  const data = rows;

  return data;
}

async function create(like){
  const result = await db.query(
    `INSERT INTO likes 
    (id, video_id, user_id, time) 
    VALUES 
    (${like.id}, ${like.video_id}, ${like.user_id}, CURTIME())`
  );

  let message = 'Error in creating programming language';

  if (result.affectedRows) {
    message = 'Like added successfully';
  }

  return {message};
}

async function remove(id){
  const result = await db.query(
    `DELETE FROM like WHERE id=${id}`
  );

  let message = 'Error in deleting like';

  if (result.affectedRows) {
    message = 'Like deleted successfully';
  }

  return {message};
}


module.exports = {
  getMultiple, 
  create,
remove
}