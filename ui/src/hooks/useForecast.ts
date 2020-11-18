import { onMounted, Ref, ref } from 'vue'

export default function (city: Ref<string>) {

	const forecasts = ref<Forecast[]>([])

	const fetchForecast = async () => {
		const response = await fetch(`/api/weather/cities/${city.value}/forecast`)
		const data = await response.json()
		
		forecasts.value = data.forecasts
			.map((x: ForecastContract) => ({
				date: new Date(x.date),
				temperature: x.temperature
			}))
			.sort((s: Forecast, t: Forecast) : number => {
				if (s.date === t.date) return 0
				return s.date < t.date ? -1 : 1
			})
	}

	onMounted(fetchForecast)

	return {
		forecasts
	}
}

interface ForecastContract {
	date: string,
	temperature: number
}

interface Forecast {
	date: Date,
	temperature: number
}
