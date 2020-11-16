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
          date: new Date().toISOString(),
          temperature: cities[request.params.id].temperature,
          description: cities[request.params.id].description
        }
      }),

      this.get('/api/weather/cities/:id/forecast', (schema, request) => {
        const next = nextISODay()
        return {
          city: request.params.id,
          forecasts: [
            {
              date: next(),
              temperature: 23
            },
            {
              date: next(),
              temperature: 21
            },
            {
              date: next(),
              temperature: 25
            },
            {
              date: next(),
              temperature: 22
            },
            {
              date: next(),
              temperature: 21
            },
            {
              date: next(),
              temperature: 23
            },
          ]
        }
      })
    }
  })
}

function nextISODay() : () => string {
  const now = new Date()
  const date = now.getDate()
  let day = 1
  return () => new Date(now.setDate(date + day++)).toISOString()
}
