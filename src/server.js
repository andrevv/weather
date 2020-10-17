import { createServer } from 'miragejs'

export default function makeServer () {
  createServer({
    routes () {
      this.get('/api/weather/cities', () => {

      })

      this.get('/api/weather/cities/:id', (schema, request) => {
        const cities = {
          moscow: 19,
          berlin: 20,
          london: 21
        }

        return cities[request.params.id]
      })
    }
  })
}
