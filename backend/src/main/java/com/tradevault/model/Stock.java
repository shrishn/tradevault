package com.tradevault.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
    

import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "ticker",unique = true, nullable = false, length = 10)
    private String ticker;

    @Column(name = "company_name",nullable = false, length = 200)
    private String companyName;

    @Column(length = 50)
    private String sector;

    @Enumerated(EnumType.STRING)
    @Column(name = "asset_type", nullable = false)
    private AssetType assetType;

    @Enumerated(EnumType.STRING)
    @Column(name = "market_cap_category")
    private MarketCapCategory marketCapCategory;

    @Column(length = 50)
    private String exchange;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public enum AssetType {
        EQUITY, ETF, MUTUAL_FUND, BOND
    }

    public enum MarketCapCategory {
        SMALL_CAP, MID_CAP, LARGE_CAP, MEGA_CAP
    }

}