export function capitalize (s: string) : string {
	return s.split(' ')
		.map(s => s.charAt(0).toUpperCase() + s.slice(1))
		.join(' ')
}
