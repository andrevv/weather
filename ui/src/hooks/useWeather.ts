import { onMounted, reactive, Ref } from 'vue'

export default function (city: Ref<string>) {

	const weather = reactive<Weather>({
		date: new Date(),
		temperature: 0
	})

	const fetchWeather = async () => {
		const response = await fetch(`/api/weather/cities/${city.value}`)
		const data = await response.json()
		weather.date = new Date(data.date)
		weather.temperature = data.temperature.celsius
	}

	onMounted(fetchWeather)

	return {
		weather
	}
}

interface Weather {
	date: Date,
	temperature: number
}
