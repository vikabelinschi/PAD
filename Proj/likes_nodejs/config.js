const config = {
  db: {
    /* don't expose password or any sensitive info, done only for demo */
    host: 'host.docker.internal',
    user: 'root',
    password: '',
    database: 'liikes'
  },
  listPerPage: 10,
};
module.exports = config;