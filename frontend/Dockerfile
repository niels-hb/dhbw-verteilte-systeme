FROM node:15-alpine as builder

WORKDIR /builds
COPY . .

RUN npm ci && npx ng build --prod

FROM nginx:alpine
COPY --from=builder /builds/dist/frontend /usr/share/nginx/html
