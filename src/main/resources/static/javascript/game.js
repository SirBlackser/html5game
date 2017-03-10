var asteroidLoader = {
    "sprites": {
        // This spritesheet has 64 images, in a 8 by 8 grid
        // The dimensions are 1024-1024
        "../images/asteroidsSprite.png": {
            // This is the width of each image in pixels
            tile: 128,
            // The height of each image
            tileh: 128,
            // We give names to three individual images
            map: {
                a01: [0, 1],
                a02: [0, 2],
                a03: [0, 3],
                a04: [0, 4],
                a05: [0, 5],
                a06: [0, 6]



            }
        }
    }
};

var asteroidSizeEnum = {
    BIG: 2,
    MEDIUM: 1,
    SMALL: 0
}

var startTime
//Only once
function init(){
    Crafty.load(asteroidLoader, null);
    var dStart = new Date();
    startTime = dStart.getTime();
}

var player;
var score;

var asteroid = Crafty.c("asteroid", {
    init: function () {
        this.origin("center");
        this.attr({
            x: 0, y: 0, w: 64, h: 64,
            speed: Math.random() * 5,
            xDir: Math.random(),
            yDir: Math.random(),
            asteroidType: asteroidSizeEnum.SMALL
        })
        .bind("EnterFrame", function () {
            this.x += this.xDir * this.speed;
            this.y += this.yDir * this.speed;

            //if ship goes out of bounds, put him back
            if (this._x > Crafty.viewport.width) {
                this.x = -64;
            }
            if (this._x < -64) {
                this.x = Crafty.viewport.width;
            }
            if (this._y > Crafty.viewport.height) {
                this.y = -64;
            }
            if (this._y < -64) {
                this.y = Crafty.viewport.height;
            }
        }).collision()
        .onHit("bullet", function (e) {
            //if hit by a bullet increment the score
            player.score += 5;
            score.text("Score: " + player.score);
            e[0].obj.destroy(); //destroy the bullet

            this.speed = Math.random() * 5;

            this.xDir = -this.xDir;
            this.yDir = -this.yDir;

            switch (this.asteroidType) {
                case asteroidSizeEnum.SMALL:
                    this.destroy();
                    return;
                    break;
                case asteroidSizeEnum.MEDIUM:
                    this.asteroidType = asteroidSizeEnum.SMALL;
                    this.w = 32;
                    this.h = 32;
                    //split into two asteroids by creating another asteroid
                    generateAsteroid(this.x, this.y, 32, this.asteroidType);
                    break;
                case asteroidSizeEnum.BIG:
                    this.asteroidType = asteroidSizeEnum.MEDIUM;
                    this.w = 64;
                    this.h = 64;
                    //split into two asteroids by creating another asteroid
                    generateAsteroid(this.x, this.y, 64, this.asteroidType);
                    break;
            }


        });
    }
});

//Restart without reloading objects etc that are still valid
function start(){
    Crafty.init(window.innerWidth,window.innerHeight, document.getElementById('game'));

    //score display
     score = Crafty.e("2D, DOM, Text")
        .text("Score: 0")
        .textFont({family: 'Arial', size:'30px', weight:'bold'})
        .attr({x: Crafty.viewport.width - 300, y: Crafty.viewport.height - 50, w: 200, h:50})
        .css({color: "#000"});


    //generateAsteroid(150, 10, 128, asteroidSizeEnum.BIG);
    //generateAsteroid(500, 300, 128, asteroidSizeEnum.BIG);
    //generateAsteroid(700, 450, 128, asteroidSizeEnum.BIG);
    //generateAsteroid(20, 600, 128, asteroidSizeEnum.BIG);

    player= Crafty.e('2D, DOM, Image, Controls, Collision')
        .attr({
            move: {
                left: false,
                right: false,
                up: false,
                down: false},
            xspeed: 0,
            yspeed: 0,
            decay: 0.995,
            x: 400,
            y: 300,
            w: 40,
            h: 40,
            score:0
        })
        .origin("center")
        // .color('#F00')
        .image("../images/ship.svg")
        .bind("KeyDown", function(e){
            //on keydown, set the move booleans
            if(e.keyCode === Crafty.keys.RIGHT_ARROW) {
                this.move.right = true;
            } else if(e.keyCode === Crafty.keys.LEFT_ARROW) {
                this.move.left = true;
            } else if(e.keyCode === Crafty.keys.UP_ARROW) {
                this.move.up = true;
            } else if (e.keyCode === Crafty.keys.SPACE) {
                //create a bullet entity
                Crafty.e("2D, DOM, Color, bullet")
                    .attr({
                        x: this._x+20,
                        y: this._y+20,
                        w: 2,
                        h: 5,
                        rotation: this._rotation,
                        xspeed: 20 * Math.sin(this._rotation / 57.3),
                        yspeed: 20 * Math.cos(this._rotation / 57.3)
                    })
                    .color("rgb(0,0,0)")
                    .bind("EnterFrame", function() {
                        this.x += this.xspeed;
                        this.y -= this.yspeed;

                        //destroy if it goes out of bounds
                        if(this._x > Crafty.viewport.width || this._x < 0 || this._y > Crafty.viewport.height || this._y < 0) {
                            this.destroy();
                        }
                    });
            }
        }).bind("KeyUp", function(e) {
            //on key up, set the move booleans to false
            if(e.keyCode === Crafty.keys.RIGHT_ARROW) {
                this.move.right = false;
            } else if(e.keyCode === Crafty.keys.LEFT_ARROW) {
                this.move.left = false;
            } else if(e.keyCode === Crafty.keys.UP_ARROW) {
                this.move.up = false;
            }
        }).bind("EnterFrame", function() {
            if(this.move.right) this.rotation += 4;
            if(this.move.left) this.rotation -= 4;

            //acceleration and movement vector
            var vx = Math.sin(this._rotation * Math.PI / 180) * 0.3,
                vy = Math.cos(this._rotation * Math.PI / 180) * 0.3;

            //if the move up is true, increment the y/xspeeds
            if(this.move.up) {
                this.yspeed -= vy;
                this.xspeed += vx;
            } else {
                //if released, slow down the ship
                this.xspeed *= this.decay;
                this.yspeed *= this.decay;
            }

            //move the ship by the x and y speeds or movement vector
            this.x += this.xspeed;
            this.y += this.yspeed;

            //if ship goes out of bounds, put him back
            if(this._x > Crafty.viewport.width) {
                this.x = -64;
            }
            if(this._x < -64) {
                this.x =  Crafty.viewport.width;
            }
            if(this._y > Crafty.viewport.height) {
                this.y = -64;
            }
            if(this._y < -64) {
                this.y = Crafty.viewport.height;
            }

        }).collision()
        .onHit("asteroid", function (e) {
            //if hit by a bullet increment the score
            player.score = 0;
            score.text("Score: " + player.score);
            e[0].obj.destroy(); //destroy the bullet
        });
}

function summonRandomAstroids()
{
    var width = Crafty.viewport.width;
    var heigth = Crafty.viewport.height;
    var Xspawn1 = Math.random()*width;
    var Yspawn1 = Math.random()*heigth;
    var Xspawn2 = Math.random()*width;
    var Yspawn2 = Math.random()*heigth;


    if(Math.random() > 0.5) {generateAsteroid(Xspawn1,0, 128, asteroidSizeEnum.BIG);}
    if(Math.random() > 0.5) {generateAsteroid(Xspawn2,heigth,128, asteroidSizeEnum.BIG);}
    if(Math.random() > 0.5) {generateAsteroid(0,Yspawn1, 128, asteroidSizeEnum.BIG);}
    if(Math.random() > 0.5) {generateAsteroid(width,Yspawn2, 128, asteroidSizeEnum.BIG);}

    setTimeout(summonRandomAstroids, 5000);

}

function generateAsteroid(x, y, size, type){

    asteroid = Crafty.e(getRandomAsteroid())
        .attr({x:x, y:y, w:size, h:size,
            speed: Math.random()*5,
            xDir: Math.random(),
            yDir: Math.random(),
            asteroidType: type});

}

function getRandomAsteroid(){
    var s;

    switch (Math.floor(Math.random()*10)) {
        case 0: s = "2D, Canvas, a01, Collision, asteroid";
            break;
        case 1: s = "2D, Canvas, a02, Collision, asteroid";
            break;
        case 2: s = "2D, Canvas, a03, Collision, asteroid";
            break;
        case 3: s = "2D, Canvas, a04, Collision, asteroid";
            break;
        case 4: s = "2D, Canvas, a05, Collision, asteroid";
            break;
        default:
            s = "2D, Canvas, a06, Collision, asteroid";
            break;
    }
    return s;
}

init();
start();
summonRandomAstroids();


//Reset Game
window.onresize = function(event) {
    Crafty.init(window.innerWidth,window.innerHeight, document.getElementById('game'));
};