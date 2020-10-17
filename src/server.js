import { createServer } from 'miragejs'

export default function makeServer () {
  createServer({
    routes () {
      this.get('/api/weather/cities', () => {

      })

      this.get('/api/weather/cities/:id', () => {
        return 19
      })
    }
  })
}
