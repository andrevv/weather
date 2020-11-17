export function dayOfWeek(date: Date) : string {
	return weekdays[date.getDay()]
}

export function dayOfMonth(date: Date) : number {
	return date.getDate()
}

const weekdays = [
	'Saturday',
	'Monday',
	'Tuesday',
	'Wednesday',
	'Thursday',
	'Friday',
	'Sunday'
]
