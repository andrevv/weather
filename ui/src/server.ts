import { createServer } from 'miragejs'

export default function makeServer () {
  createServer({
    routes () {
      this.get('/api/weather/cities/:id', (schema, request) => {
        const cities = {
          moscow: {
            description: 'clear',
            temperature: {
              celsius: 19,
              fahrenheit: 66
            }
          },
          berlin: {
            description: 'cloudy',
            temperature: {
              celsius: 20,
              fahrenheit: 68
            }
          },
          london: {
            description: 'rain',
            temperature: {
              celsius: 21,
              fahrenheit: 70
            }
          }
        }

        return {
          city: request.params.id,
          temperature: cities[request.params.id].temperature,
          description: cities[request.params.id].description
        }
      })
    }
  })
}
