import { createServer } from 'miragejs'

export default function makeServer () {
  createServer({
    routes () {
      this.get('/api/weather/cities', () => {

      })

      this.get('/api/weather/cities/:id', (schema, request) => {
        const cities = {
          moscow: { celsius: 19, fahrenheit: 66 },
          berlin: { celsius: 20, fahrenheit: 68 },
          london: { celsius: 21, fahrenheit: 70 }
        }

        return cities[request.params.id]
      })
    }
  })
}
