const express = require('express');
const router = express.Router();
const gets = require('./gets');


/* GET likes. */
router.get('/:video_id', async function(req, res, next) {
  try {
    res.json(await gets.getMultiple(req.params.video_id));
  } catch (err) {
    console.error(`Error while getting programming languages `, err.message);
    next(err);
  }
});

/* POST likes*/
router.post('/', async function(req, res, next) {
  try {
    res.json(await gets.create(req.body));
  } catch (err) {
    console.error(`Error while adding like`, err.message);
    next(err);
  }
});

/* DELETE likes */
router.delete('/:id', async function(req, res, next) {
  try {
    res.json(await gets.remove(req.params.id));
  } catch (err) {
    console.error(`Error while deleting like`, err.message);
    next(err);
  }
});


module.exports = router;