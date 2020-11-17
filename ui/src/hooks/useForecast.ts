import { onMounted, Ref, ref } from 'vue'

export default function (city: Ref<string>) {

	const forecasts = ref<Forecast[]>([])

	const fetchForecast = async () => {
		const response = await fetch(`/api/weather/cities/${city.value}/forecast`)
		const data = await response.json()
		
		forecasts.value = data.forecasts.map((x: { date: string; temperature: number }) => ({
			date: new Date(x.date),
			temperature: x.temperature
		}))
	}

	onMounted(fetchForecast)

	return {
		forecasts
	}
}

interface Forecast {
	date: Date,
	temperature: number
}
