# Developer for a Day Frontend (10.06.2022)

## Welcome to Developer for a day!

### Introduction & Setup

You will implement features for an [Angular 13](https://angular.io/) Frontend Application. The App shows weather stations that are fetched from the weather backend.

#### What you need to start

- Install Nodejs [nodejs](https://nodejs.org/)
- Install the package manager [npm](https://docs.npmjs.com/getting-started/what-is-npm)
- run `npm install -g @angular/cli`
- Navigate to the project
- run `npm install`
- run `ng serve` (Webpage will refresh automatically)
- start coding

#### Useful Links

- [What is Angular?](https://angular.io/guide/what-is-angular)
- [Bootstrap 5 Cheat Sheet](https://getbootstrap.com/docs/5.0/examples/cheatsheet/)
- [CSS Cheat Sheet](https://htmlcheatsheet.com/css/)
- [Angular](https://angular.io/guide/cheatsheet)

## Implementation

### Task Beginner: Implement APIs from the backend and modal

This task is divided in two parts. The first part is to implement the CRUD Operations, so that the weather data can be manipulated with the frontend. The weather stations are already read from the Backend and since we won't update the stations we will not implement the update operation.

#### CRUD

(What is CRUD?) [https://en.wikipedia.org/wiki/Create,_read,_update_and_delete]
There are already 3 methods in the `app.component.ts` file which should call their respective API. The API implementation can be found in `weather-station.service.ts`.

#### Delete Modal

It is always nice to get asked if 'You really want to delete that object?' before deleting it. This task is to implement a modal that popups before deleting an object. Take a look how it is made when adding a weather station.

### Task Advanced: Implement Weather Map API

The Backend has an API which returns all weather stations and their data. Right now get fetch all stations IDs and then fetch one by one the data. We can combine these steps by just calling the weather map.

[GET] fetchWeatherMap: `/api/map`

___
___

## Development server

Run `ng serve` or `npm run start` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
