'use strict';

module.exports = (sequelize, DataTypes) => {
    let Computador = sequelize.define('Computador', {
        idComputador: {
            field: 'idComputador',
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        nomeComputador: {
            field: 'nomeComputador',
            type: DataTypes.STRING,
            allowNull: false
        },
        fkEscola: {
            field: 'fkEscola',
            type: DataTypes.INTEGER,
            allowNull: false
        },
    },
        {
            tableName: 'Computador',
            freezeTableName: true,
            underscored: true,
            timestamps: false,
        });

    return Computador;
};
