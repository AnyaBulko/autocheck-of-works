const path = require('path');
const {VueLoaderPlugin} = require('vue-loader')

module.exports = {

    mode: 'development',
    devtool: 'source-map',
    // файл, с которого собирается исходный код
    entry: path.join(__dirname, 'src', 'main', 'resources', 'static', 'js', 'main.js'),
    devServer: {
        // добавила, чтобы работали иконки!! и чтобы горячая загрузка работала
        headers: {
            "Access-Control-Allow-Origin": "http://localhost:9000"
        },
        // по умолчанию скомпилированные файлы будут тут
        static: './dist',
        compress: true,
        port: 8000,
        allowedHosts: [
            'localhost:9000'
        ]
    },
    module: {
        rules: [
            // через babel проходят js файлы
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            // vue через vue-loader
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.css$/,
                use: [
                    'vue-style-loader',
                    'css-loader'
                ]
            },
        ]
    },
    plugins: [
        new VueLoaderPlugin()
    ],
    // модули которые будут видны? что-то для импортов
    resolve: {
        modules: [
            path.join(__dirname, 'src', 'main', 'resources', 'static', 'js'),
            path.join(__dirname, 'node_modules'),
        ],
    }
}