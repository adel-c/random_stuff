import { invoke } from '@tauri-apps/api'

export function setupCounter(element: HTMLButtonElement) {
  let counter = 0
  const setCounter = (count: number) => {
    counter = count
    element.innerHTML = `count is ${counter}`
  }
  invoke('greet', { name: 'jean' })
  // `invoke` returns a Promise
  .then((response) =>   element.innerHTML = `${response} is ${counter}`)
  element.addEventListener('click', () => setCounter(counter + 1))
  setCounter(0)
}
